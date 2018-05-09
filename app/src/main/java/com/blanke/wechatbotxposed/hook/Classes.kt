package com.blanke.wechatbotxposed.hook

import com.gh0u1l5.wechatmagician.spellbook.C
import com.gh0u1l5.wechatmagician.spellbook.WechatGlobal.wxClasses
import com.gh0u1l5.wechatmagician.spellbook.WechatGlobal.wxLazy
import com.gh0u1l5.wechatmagician.spellbook.WechatGlobal.wxLoader
import com.gh0u1l5.wechatmagician.spellbook.WechatGlobal.wxPackageName
import com.gh0u1l5.wechatmagician.spellbook.util.ReflectionUtil.findClassesFromPackage

object Classes {
    // 这个类有一个方法可以直接发送消息
    val ChattingFooterEventImpl: Class<*> by wxLazy("ChattingFooterEventImpl") {
        findClassesFromPackage(wxLoader!!, wxClasses!!, "$wxPackageName.ui.chatting")
                .filterByField("android.media.ToneGenerator")
                .filterByField("android.os.Vibrator")
                .firstOrNull()
    }

    // 发送消息的封装类，可以 hook 消息目的地
    val NetSceneSendMsg: Class<*> by wxLazy("NetSceneSendMsg") {
        findClassesFromPackage(wxLoader!!, wxClasses!!, "$wxPackageName.modelmulti")
                .filterByField("java.util.List")
                .filterByField("long")
                .filterByMethod(C.String, C.String, C.Object, C.Int)
                .filterByMethod(C.Int, "getType")
                .firstOrNull()
    }
}