package com.example.demo.handler;

import com.example.demo.service.DemoService;
import com.glodon.coral.contexts.Contexts;
import com.glodon.coral.meta.data.api.Document;
import com.glodon.coral.meta.data.client.remote.DocumentOperations;
import com.glodon.gcdp.common.handler.DocHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 控制器
 */
@Component
@Slf4j
public class DemoHandler extends DocHandler<DemoService> {

    @Autowired
    private DemoService demoService;

    /**
     * 构造函数
     *
     * @param demoService 示例服务
     */
    public DemoHandler(DemoService demoService) {
        super(demoService);
        this.demoService = demoService;
    }

    /**
     * 自定义方法
     *
     * @param document           文档对象
     * @param documentOperations 文档操作工具类
     * @param contexts           上下文
     */
    public void custom(Document document, DocumentOperations documentOperations, Contexts contexts) {
        demoService.custom(document, documentOperations, contexts);
    }
}
