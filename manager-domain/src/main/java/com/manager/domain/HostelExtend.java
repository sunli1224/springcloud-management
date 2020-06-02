package com.manager.domain;

import lombok.*;

import java.util.List;

/**
 * @author sunli
 * @date 2020/4/9 21:59
 */

@Getter
@Setter
public class HostelExtend extends Hostel {
    private Floor floor;
    private List<Floor> floorList;
}
