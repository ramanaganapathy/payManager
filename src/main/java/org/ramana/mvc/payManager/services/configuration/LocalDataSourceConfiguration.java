package org.ramana.mvc.payManager.services.configuration;


import java.sql.Driver;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.dialect.MySQL5Dialect;
import org.hibernate.ejb.HibernatePersistence;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.concurrent.ConcurrentMapCache;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

@Configuration
@Profile("default")
public class LocalDataSourceConfiguration   {


    @Bean
    public DataSource dataSource( Environment environment ) throws Exception {

//        return new EmbeddedDatabaseBuilder()
//                .setName("paymanager")
//                .setType(EmbeddedDatabaseType.H2)
//                .build();

        
        String user = environment.getProperty("ds.user"),
                pw = environment.getProperty("ds.password"),
                url = environment.getProperty("ds.url");
        Class<Driver> driverClass = environment.getPropertyAsClass( "ds.driverClass", Driver.class );

        BasicDataSource basicDataSource = new BasicDataSource();
        basicDataSource.setDriverClassName( driverClass.getName() );
        basicDataSource.setPassword( pw );
        basicDataSource.setUrl( url );
        basicDataSource.setUsername( user );
        basicDataSource.setInitialSize( 5 );
        basicDataSource.setMaxActive( 10 );
        return basicDataSource;
        

    }

    @Bean
    public LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean( DataSource dataSource  ) throws Exception {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource( dataSource );
        em.setPackagesToScan("org.ramana.mvc.payManager.services");
        em.setPersistenceProvider(new HibernatePersistence());
        Map<String, String> p = new HashMap<String, String>();
        p.put(org.hibernate.cfg.Environment.HBM2DDL_AUTO, "update");
//        p.put(org.hibernate.cfg.Environment.HBM2DDL_IMPORT_FILES, "import_h2.sql");
//        p.put(org.hibernate.cfg.Environment.CHECK_NULLABILITY, "true");
        p.put(org.hibernate.cfg.Environment.DIALECT,MySQL5Dialect.class.getName());
        p.put(org.hibernate.cfg.Environment.FORMAT_SQL,"true");
        p.put(org.hibernate.cfg.Environment.AUTOCOMMIT,"true");
        p.put(org.hibernate.cfg.Environment.C3P0_TIMEOUT,"3");
        p.put(org.hibernate.cfg.Environment.FLUSH_BEFORE_COMPLETION,"true");
        p.put(org.hibernate.cfg.Environment.SHOW_SQL, "true");
        em.setJpaPropertyMap(p);
        return em;
    }

    @Bean
    public CacheManager cacheManager() throws Exception {
        SimpleCacheManager scm = new SimpleCacheManager();
        Cache cache = new ConcurrentMapCache("employees");
        Cache cache2 = new ConcurrentMapCache("projects");
        scm.setCaches(Arrays.asList(cache,cache2));
        return scm;
    }

}
