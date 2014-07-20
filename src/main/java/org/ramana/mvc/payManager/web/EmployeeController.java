/**
 * 
 */
package org.ramana.mvc.payManager.web;

import java.util.Collection;

import org.apache.log4j.Logger;
import org.ramana.mvc.payManager.domain.Employee;
import org.ramana.mvc.payManager.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author ramana
 *
 */
public class EmployeeController {

	 private Logger log = Logger.getLogger(getClass());

	    @Autowired
	    private EmployeeService employeeService;

	    public static final String EmployeeS_ENTRY_URL = "/paymanager/employees";
	    public static final String EmployeeS_SEARCH_URL = "/paymanager/search";
	    public static final String EmployeeS_BY_ID_ENTRY_URL = EmployeeS_ENTRY_URL + "/{id}";

	    @ResponseBody
	    @RequestMapping(value = EmployeeS_SEARCH_URL, method = RequestMethod.GET)
	    public Collection<Employee> search(@RequestParam("q") String query) throws Exception {
	        Collection<Employee> Employees = employeeService.search(query);
	        if (log.isDebugEnabled())
	            log.debug(String.format("retrieved %s results for search query '%s'", Integer.toString(Employees.size()), query));
	        return Employees;
	    }
}
