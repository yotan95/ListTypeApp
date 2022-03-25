package com.practice.listtypeapp.di;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import javax.inject.Scope;

// 프레그먼트 범위 지정자
@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface FragmentScope {
}
