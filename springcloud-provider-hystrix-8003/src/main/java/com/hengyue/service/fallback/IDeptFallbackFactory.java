package com.hengyue.service.fallback;

import com.hengyue.entity.Dept;
import com.hengyue.service.IDeptService;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 服务降级
 */
@Component
public class IDeptFallbackFactory implements FallbackFactory {
    @Override
    public Object create(Throwable throwable) {
        return new IDeptService() {
            @Override
            public boolean doCreate(Dept dept) {
                return false;
            }

            @Override
            public List<Dept> listAll() {
                return null;
            }

            @Override
            public Dept findByDeptNo(Long deptno) {
                Dept dept = new Dept(10L, "test", "test");
                return dept;
            }
        };
    }
}
