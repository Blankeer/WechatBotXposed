package com.blanke.wechatbotxposed.hook

import com.gh0u1l5.wechatmagician.spellbook.C
import com.gh0u1l5.wechatmagician.spellbook.WechatGlobal.wxLazy
import com.gh0u1l5.wechatmagician.spellbook.util.ReflectionUtil.findMethodsByExactParameters
import java.lang.reflect.Method

object Methods {
    // 这个方法可以直接发送消息
    val ChattingFooterEventImpl_SendMsg: Method by wxLazy("ChattingFooterEventImpl_SendMsg") {
        findMethodsByExactParameters(Classes.ChattingFooterEventImpl, C.Boolean, C.String).firstOrNull()
    }
}