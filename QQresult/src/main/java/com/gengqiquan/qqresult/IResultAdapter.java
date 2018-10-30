package com.gengqiquan.qqresult;

public interface IResultAdapter<T> {
    T adapter(QQResult.Builder builder);
}
