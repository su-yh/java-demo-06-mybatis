package com.suyh0605.typehandler;

import com.baomidou.mybatisplus.extension.handlers.AbstractJsonTypeHandler;
import com.baomidou.mybatisplus.extension.handlers.JacksonTypeHandler;
import com.suyh0605.util.JsonUtil;

import java.util.List;

/**
 * @author suyh
 * @since 2023-12-02
 * @param <E> 可以是对象，也可以是枚举。应该也可以是 Integer Long String 等(这个是没有测.)
 */
public abstract class AbstractListTypeHandler<E> extends AbstractJsonTypeHandler<List<E>> {
    private final Class<E> type;
    public AbstractListTypeHandler(Class<E> type) {
        this.type = type;
    }

    @Override
    protected List<E> parse(String json) {
        return JsonUtil.deserializeToList02(json, type, JacksonTypeHandler.getObjectMapper());
    }

    @Override
    protected String toJson(List<E> obj) {
        return JsonUtil.serializable(obj, JacksonTypeHandler.getObjectMapper());
    }
}
