package com.hunre.edu.laptop.services;

import com.hunre.edu.laptop.dtos.responses.ResponseMessage;
import com.hunre.edu.laptop.dtos.responses.VoucherResponse;
import com.hunre.edu.laptop.models.User;
import com.hunre.edu.laptop.models.Voucher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface VoucherService {
    Voucher createVoucher(Voucher voucher);
    Voucher updateVoucher(Long id, Voucher updatedVoucher);
    ResponseMessage deleteVoucher(Long id);
    Voucher validateVoucher(String code, User user);
    void decrementVoucherUsage(Voucher voucher);
    Voucher getVoucherById(Long id);
    List<Voucher> getActiveVouchers();
    void recordVoucherUsage(User user, Voucher voucher);
    boolean isVoucherUsedByUser(User user, Voucher voucher);
    Voucher getVoucherConsistent();
    List<VoucherResponse> getVouchersActiveHasStatusByUser(String username);
    Page<Voucher> getAllVouchers(String keyword, String status, Pageable pageable);
}
