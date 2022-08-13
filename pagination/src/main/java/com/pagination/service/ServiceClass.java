package com.pagination.service;

import com.pagination.entity.Registration;
import com.pagination.util.Pagination;
import lombok.Getter;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
@Getter
public class ServiceClass {
    private final List<Object> list = new ArrayList<>();

    public void loadRegs() {
        list.add(new Registration(1L, "Reg1"));
        list.add(new Registration(2L, "Reg2"));
        list.add(new Registration(3L, "Reg3"));
        list.add(new Registration(4L, "Reg4"));
        list.add(new Registration(5L, "Reg5"));
        list.add(new Registration(6L, "Reg6"));
        list.add(new Registration(7L, "Reg7"));
        list.add(new Registration(8L, "Reg8"));
        list.add(new Registration(9L, "Reg9"));
        list.add(new Registration(10L, "Reg10"));
    }

    public void cleanRegs() {
        list.clear();
    }

    public Pagination findAll(int page, int pageSize) {
        cleanRegs();
        loadRegs();
        return Pagination.createPage(list, page, pageSize);
    }
}
