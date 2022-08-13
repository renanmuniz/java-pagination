package com.pagination.util;

import com.pagination.entity.Registration;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Pagination {

    private Integer totalRegs;
    private Integer showPerPage;
    private Integer currentPage;
    private Integer totalPages;
    private Integer remainingPagesForward;
    private Integer remainingPagesBackward;

    private List<Object> registers;

    public static Pagination createPage(List<Object> results, Integer page, Integer pageSize) {

        if(page==0)
            page = 1;
        if(pageSize==0)
            pageSize = results.size();

        Integer totalPages = getTotalPages(pageSize, results.size());

        if(page > totalPages)
            page = totalPages;

        final Pagination pagination = new Pagination();
        pagination.setTotalRegs(results.size());
        pagination.setShowPerPage(pageSize);
        pagination.setTotalPages(totalPages);
        pagination.setRemainingPagesForward(totalPages - page);
        pagination.setRemainingPagesBackward(page - 1);
        pagination.setCurrentPage(page);


        List<Object> paginatedList = new ArrayList<>();
        for (int x = ((page - 1) * pageSize); x < (page * pageSize); x++) {
            if (x < results.size())
                paginatedList.add(results.get(x));
        }
        pagination.setRegisters(paginatedList);

        return pagination;
    }

    private static Integer getTotalPages(final Integer pageSize, final Integer totalOfElements) {
        var result = totalOfElements % pageSize;
        if (result == 0) {
            return totalOfElements / pageSize;
        }
        return ((totalOfElements - result) / pageSize) + 1;
    }

}
