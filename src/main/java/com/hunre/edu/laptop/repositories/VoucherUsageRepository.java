package com.hunre.edu.laptop.repositories;

import com.hunre.edu.laptop.models.User;
import com.hunre.edu.laptop.models.Voucher;
import com.hunre.edu.laptop.models.VoucherUsage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VoucherUsageRepository extends JpaRepository<VoucherUsage, Long> {
    boolean existsByUserAndVoucher(User user, Voucher voucher);
}