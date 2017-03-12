package web;

import form.AjaxResult;

/**
 * Created by jxilong on 2016/7/10.
 */
public interface AjaxProcesor<R> {

    void processor(R form, AjaxResult result);
}
