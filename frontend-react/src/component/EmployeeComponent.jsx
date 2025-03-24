import React, { Component } from 'react';
import employeeService from '../service/employee-service';

class EmployeeComponent extends Component {
    constructor(props) {
        super(props);

        this.state = {
            employeeDto: {},
            departmentDto: {}
        };
    }

    componentDidMount() {
        employeeService.getEmployee().then((response) => {
            this.setState(
                {
                    employee: response.data.employeeDto || {},  // Prevent undefined state
                    department: response.data.departmentDto || {}
                },
                () => {
                    // ✅ Logging inside setState callback ensures updated values
                    console.log( this.state.employee);
                    console.log( this.state.department);
                }
            );
        }).catch(error => {
            console.error("Error fetching employee data:", error);
        });
    }

    render() {
        return (
            <div>
                <h2>Employee Details</h2>
                <p><strong>Name:</strong> {this.state.employee?.name || "Loading..."}</p>
                <p><strong>Department:</strong> {this.state.department?.name || "Loading..."}</p>
            </div>
        );
    }
}

export default EmployeeComponent;
