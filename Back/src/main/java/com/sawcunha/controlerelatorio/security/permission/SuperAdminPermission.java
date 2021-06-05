package com.sawcunha.controlerelatorio.security.permission;

import org.springframework.security.access.prepost.PreAuthorize;

import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Inherited
@Retention(RetentionPolicy.RUNTIME)
@PreAuthorize("hasRole(T(com.sawcunha.controlerelatorio.enums.eTypeRole).SUPER_ADMIN.name())")
public @interface SuperAdminPermission {

}