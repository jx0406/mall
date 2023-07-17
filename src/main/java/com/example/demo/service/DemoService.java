package com.example.demo.service;

import com.glodon.coral.contexts.Contexts;
import com.glodon.coral.meta.data.api.Document;
import com.glodon.coral.meta.data.client.remote.DocumentOperations;
import com.glodon.coral.meta.service.data.handler.DocService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * 业务逻辑层
 */
@Service
@Slf4j
public class DemoService extends DocService {


    /**
     * 根据指定id删除对应的记录
     *
     * @param id                 id
     * @param documentOperations 文档操作工具类
     * @param contexts           上下文
     */
    @Override
    public void delete(Long id, DocumentOperations documentOperations, Contexts contexts) {
        // TODO 重写删除逻辑
    }

    /**
     * 自定义方法
     *
     * @param document           文档对象
     * @param documentOperations 文档操作工具类
     * @param contexts           上下文
     * @return
     */
    public void custom(Document document, DocumentOperations documentOperations, Contexts contexts) {
        // TODO 自定义业务逻辑
    }

}
