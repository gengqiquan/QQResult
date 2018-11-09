package com.gengqiquan.qqresult;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
/**
 * Created by gengqiquan on 2018/10/10.
 */

/**
 * @author gengqiquan
 * @date 2018/10/17 下午3:29
 */
 public class QQResult {

    public static Builder startActivityWith(Context context, Class cls) {
        if (!(context instanceof Activity))
            throw new RuntimeException("context must be activity ");
        return new Builder(context, new Intent(context, cls));
    }

    public static Builder startActivityWith(Context context, Intent intent) {
        if (!(context instanceof Activity))
            throw new RuntimeException("context must be activity ");
        return new Builder(context, intent);
    }

    public static class Builder {
        Context context;
        IResult result;
        Bundle data = new Bundle();
        Intent intent;

        private Builder(Context t, Intent i) {
            context = t;
            intent = i;
        }

        public <T> T transform(IResultAdapter<T> adapter) {
            return adapter.adapter(this);
        }

        public void result(@NonNull Func1 func1) {
            result(new ResultProxy(func1, new Func2() {
                @Override
                public void cancel() {

                }
            }));
        }

        public void result(@NonNull Func1 func1, @NonNull Func2 func2) {
            result(new ResultProxy(func1, func2));
        }


        public void result(@NonNull final IResult r) {
            result = r;
            if (!data.isEmpty()) {
                intent.putExtras(data);
            }

            Request request = new Request(intent);
            request.subscribe(new Observer() {
                @Override
                public void update(int resultCode, Intent data) {
                    if (resultCode == Activity.RESULT_OK) {
                        result.result(data);
                    } else {
                        result.cancel();
                    }
                }
            });

            final VirtualFragment appFragment = new VirtualFragment();
            appFragment.setRequest(request);

            ((Activity) context).getFragmentManager()
                    .beginTransaction().replace(android.R.id.content, appFragment)
                    .commitAllowingStateLoss();
        }

        public Builder put(String key, Object value) {
            ResultKt.put(data, key, value);
            return this;
        }

        public Builder putAll(Bundle bundle) {
            data.putAll(bundle);
            return this;
        }


    }
}
