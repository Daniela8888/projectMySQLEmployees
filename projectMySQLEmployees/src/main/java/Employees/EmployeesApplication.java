package Employees;

import Employees.resources.employee;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class EmployeesApplication extends Application<EmployeesConfiguration> {

    public static void main(final String[] args) throws Exception {
        new EmployeesApplication().run(args);
    }

    @Override
    public String getName() {
        return "Employees";
    }

    @Override
    public void initialize(final Bootstrap<EmployeesConfiguration> bootstrap) {
        // TODO: application initialization
    }


    @Override
    public void run(final EmployeesConfiguration configuration,
                    final Environment environment) {
        // TODO: implement application

        environment.jersey().register(
                new employee();
        )

    }

}
