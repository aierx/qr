package icu.aierx.boot.channel;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.Arrays;

public class WearkRefTest {
    static class WeakReferenceExt<String> extends WeakReference<String> {
        public WeakReferenceExt(String referent, ReferenceQueue rq) {
            super(referent, rq);
        }
        public void clean() {
            System.out.println("do some cleaning");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        // 创建一个大点的对象
        char[] chars = new char[1024 << 16];
        Arrays.fill(chars, 'z');
        String str = new String(chars);
        // 创建弱引用
        ReferenceQueue rq = new ReferenceQueue();
        WeakReference weak = new WeakReferenceExt(str, rq);
        str = null;
        System.out.println(((String)weak.get()).length());
        // 建议 GC，执行 GC 后，对象会被回收，弱引用放入队列
        System.gc();
        System.out.println("-------------");
        // 阻塞，从队列中弹出弱引用
        WeakReferenceExt remove = (WeakReferenceExt)rq.remove();
        // 触发业务清理动作
        remove.clean();
        // 抛空指针异常
        System.out.println(((String)weak.get()).length());
    }
}