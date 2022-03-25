package com.practice.listtypeapp.di;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import javax.inject.Qualifier;

// 액티비티 Context 한정
@Qualifier
@Retention(RetentionPolicy.RUNTIME)
public @interface ActivityContext {
}

