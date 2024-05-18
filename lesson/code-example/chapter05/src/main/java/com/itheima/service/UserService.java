package com.itheima.service;

import com.itheima.domain.User;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
public class UserService {

    // pageNum当前页号，pageSize每页显示的记录数
    public Page<User> getUserPage(int pageNum, int pageSize) {
        Sort.Order order = new Sort.Order(Sort.Direction.DESC, "id");
        Pageable pageable = PageRequest.of(pageNum, pageSize, Sort.by(order));
        int totalElements = getTotalElements();
        List<User> userList = new ArrayList<>();
        int fromIndex = pageNum * pageSize;
        int toIndex = (pageNum + 1) * pageSize;
        if (toIndex > totalElements) toIndex = totalElements;
        for (int i = fromIndex; i < toIndex; i++) {
            User user = new User();
            user.setId(i);
            user.setUsername("UserName" + i);
            user.setPhone("Phone" + i);
            userList.add(user);
        }
        userList.sort(new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                if (pageable.getSort().getOrderFor("id").isAscending())
                    return o1.getId().compareTo(o2.getId());
                else
                    return o2.getId().compareTo(o1.getId());
            }
        });
        return new PageImpl<>(userList, pageable, totalElements);
    }

    private int getTotalElements() {
        return 23;
    }
}
