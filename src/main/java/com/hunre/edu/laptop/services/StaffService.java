package com.hunre.edu.laptop.services;

import com.hunre.edu.laptop.dtos.requests.StaffAccountSignup;
import com.hunre.edu.laptop.dtos.responses.AccountStaffResponse;
import com.hunre.edu.laptop.dtos.responses.ResponseMessage;
import com.hunre.edu.laptop.models.Staff;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface StaffService {
    void createStaff(Staff staff);
    Staff getStaffById(Long id);
    Staff getStaffByUsername(String username);
    Page<Staff> getAllStaffsByKeyword(String keyword, Pageable pageable);
    ResponseMessage updateStaffStatus(Long id);
    AccountStaffResponse getStaffInfo(Long id);
    Page<AccountStaffResponse> getAllStaffs(String keyword, String status, Pageable pageable);
    Staff updateStaff(Staff staff, Long id);
    ResponseMessage deleteStaff(Long id);
}
