package com.microservices.employee_service.service.externalAPI;

import com.microservices.employee_service.dto.DepartmentDto;
import com.microservices.employee_service.exception.ApiClientException;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Component
public class ApiClient {
    private final RestTemplate restTemplate;

    public ApiClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public DepartmentDto getDepartment(String departmentCode) {
        // URL oluşturulurken UriComponentsBuilder kullanılır.
        String url = UriComponentsBuilder
                .fromHttpUrl("http://localhost:8080/api/department/")
                .pathSegment(departmentCode)
                .toUriString();

        try {
            // RestTemplate ile API çağrısı yapılır.
            return restTemplate.getForObject(url, DepartmentDto.class);
        } catch (HttpClientErrorException.NotFound e) {
            // 404 durumunda özel bir mesaj
            throw new ApiClientException("Department not found with code: " + departmentCode, "departmentCode", departmentCode);

        }
    }
}