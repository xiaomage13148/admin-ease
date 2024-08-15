package com.ease.admin.common.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * 数据填充功能
 * Description: <br/>
 *
 * @author mjh8 <br/>
 * @date: 2024/8/15 下午4:02 <br/>
 * @since JDK 17
 */
@Component
public class ProgramMetaObjectHandler implements MetaObjectHandler {

    private static final String CREATOR = "creator";
    private static final String CREATETIME = "createTime";
    private static final String UPDATER = "updater";
    private static final String UPDATETIME = "updateTime";

    // TODO 默认的用户ID
    private static final String userId = "defaultUserId";

    @Override
    public void insertFill(MetaObject metaObject) {
        LocalDateTime now = LocalDateTime.now();
        this.strictInsertFill(metaObject, CREATOR, String.class, userId);
        this.strictInsertFill(metaObject, UPDATER, String.class, userId);
        this.strictInsertFill(metaObject, CREATETIME, LocalDateTime.class, now);
        this.strictInsertFill(metaObject, UPDATETIME, LocalDateTime.class, now);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        LocalDateTime now = LocalDateTime.now();
        this.strictUpdateFill(metaObject, UPDATER, String.class, userId);
        this.strictUpdateFill(metaObject, UPDATETIME, LocalDateTime.class, now);
    }
}
