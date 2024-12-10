package com.microservices.employee_service.service;

import com.microservices.employee_service.dto.APIResponseDto;
import com.microservices.employee_service.dto.DepartmentDto;
import com.microservices.employee_service.dto.EmployeeDto;
import com.microservices.employee_service.entity.Employee;
import com.microservices.employee_service.repository.EmployeeRepository;

import com.microservices.employee_service.service.externalAPI.Client;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    private final ModelMapper modelMapper;

    private final Client client;

    //private final WebClient webClient;


    //APICLIENT
    public EmployeeService(EmployeeRepository employeeRepository, ModelMapper model, Client client) {
        this.employeeRepository = employeeRepository;
        this.modelMapper = model;
        this.client = client;
    }
    public EmployeeDto createEmployee(EmployeeDto employeeDto){
        return modelMapper.map(employeeRepository.save(modelMapper.map(employeeDto, Employee.class)),EmployeeDto.class);
    }
    public APIResponseDto getEmployee(Long employeeId){
            Employee employee = employeeRepository.findById(employeeId)
                    .orElseThrow(() -> new RuntimeException("Employee not found"));

            //RestTemplate
            //DepartmentDto departmentDto = apiClient.getDepartment(employee.getDepartmentCode());

            // WebClient
            //DepartmentDto departmentDto = webClient.get().uri("http://localhost:8080/api/department/{departmentCode}", employee.getDepartmentCode()).retrieve().bodyToMono(DepartmentDto.class).block();
            DepartmentDto  departmentDto = client.getDepartment(employee.getDepartmentCode());
            if(employee.getDepartmentCode().equalsIgnoreCase(departmentDto.getDepartmentCode())){
                EmployeeDto employeeDto = modelMapper.map(employee, EmployeeDto.class);

                // Construct APIResponseDto
                APIResponseDto apiResponseDto = new APIResponseDto();
                apiResponseDto.setEmployeeDto(employeeDto);
                apiResponseDto.setDepartmentDto(departmentDto);

                return apiResponseDto;
            }
            throw new RuntimeException("Incorrect department");
        }
    }

