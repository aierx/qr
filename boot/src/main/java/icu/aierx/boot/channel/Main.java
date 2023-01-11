package icu.aierx.boot.channel;

import java.io.IOException;
import java.nio.channels.Selector;

/**
 * @author leiwenyong
 * @since 2023-01-09
 */
public class Main {
	public static void main(String[] args) throws IOException {
		Selector selector = Selector.open();
		selector.wakeup();
		selector.selectNow();
		selector.wakeup();
		selector.selectNow();
		selector.wakeup();
		selector.selectNow();
	}
}
