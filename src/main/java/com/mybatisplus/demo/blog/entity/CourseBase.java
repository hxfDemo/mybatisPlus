package com.mybatisplus.demo.blog.entity;

import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author hxf
 * @since 2020-05-28
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="CourseBase对象", description="")
public class CourseBase implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "课程名称")
    private String name;

    @ApiModelProperty(value = "适用人群")
    private String users;

    @ApiModelProperty(value = "课程大分类")
    private String mt;

    @ApiModelProperty(value = "课程等级")
    private String grade;

    @ApiModelProperty(value = "学习模式")
    private String studymodel;

    @ApiModelProperty(value = "授课模式")
    private String teachmode;

    @ApiModelProperty(value = "课程介绍")
    private String description;

    @ApiModelProperty(value = "课程小分类")
    private String st;

    @ApiModelProperty(value = "课程状态")
    private String status;

    @ApiModelProperty(value = "教育机构")
    private String companyId;

    @ApiModelProperty(value = "创建用户")
    private String userId;


}
