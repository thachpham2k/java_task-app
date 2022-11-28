//package com.web.entities;
//
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//import javax.persistence.*;
//
//@Data
//@NoArgsConstructor
//@AllArgsConstructor
//@Entity
//@Table(name="project_manage")
//public class ProjectManage {
//    @EmbeddedId
//    private ProjectManageKey pmKey;
//
//    @Column(name="description")
//    private String description;
//
//    @ManyToOne
//    @JoinColumn(name="project_id", insertable = false, updatable = false)
//    private Project project;
//
//    @ManyToOne
//    @JoinColumn(name="pm_id", insertable = false, updatable = false)
//    private User projectManager;
//}
