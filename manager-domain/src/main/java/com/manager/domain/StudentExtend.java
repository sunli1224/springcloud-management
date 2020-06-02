package com.manager.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author sunli
 * @date 2020/3/17 16:53
 */
@Getter
@Setter
public class StudentExtend extends Student {
    private Hostel hostel;
    private List<Floor> floorList;
    private List<Hostel> hostelList;
}
