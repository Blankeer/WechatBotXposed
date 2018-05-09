package com.blanke.wechatbotxposed

import com.blanke.wechatbotxposed.hook.SendMsgHooker
import com.blanke.wechatbotxposed.hook.WechatMessageHook
import com.gh0u1l5.wechatmagician.spellbook.SpellBook
import com.gh0u1l5.wechatmagician.spellbook.util.BasicUtil
import de.robv.android.xposed.IXposedHookLoadPackage
import de.robv.android.xposed.XposedBridge
import de.robv.android.xposed.callbacks.XC_LoadPackage

class WechatHook : IXposedHookLoadPackage {
    override fun handleLoadPackage(lpparam: XC_LoadPackage.LoadPackageParam) {
        BasicUtil.tryVerbosely {
            if (SpellBook.isImportantWechatProcess(lpparam)) {
                XposedBridge.log("Hello Wechat!")
                SpellBook.startup(lpparam, listOf(
                        WechatMessageHook
                ), listOf(
                        SendMsgHooker
                ))
            }
        }
    }
}