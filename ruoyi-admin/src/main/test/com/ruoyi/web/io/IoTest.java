package com.ruoyi.web.io;

import com.ruoyi.common.core.utils.UrlToMultipartFileUtil;
import org.apache.commons.io.IOUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;

@SpringBootTest
class IoTest {
	/**
	 * 下载网络图片
	 */
	@Test
	void contextLoads() {
		//指定输出到某个位置
		MultipartFile multipartFile = UrlToMultipartFileUtil.urlToMultipartFile("https://gimg2.baidu.com/image_search/src=http%3A%2F%2Flmg.jj20.com%2Fup%2Fallimg%2F1114%2F040221103339%2F210402103339-8-1200.jpg&refer=http%3A%2F%2Flmg.jj20.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=auto?sec=1671595329&t=5ec956a905e71e684a67bcb53b014d2f", "花.jpg");
		String saveResult = UrlToMultipartFileUtil.saveMultipartFile(multipartFile, "G:\\img");
		System.out.println(saveResult);
	}

	/**
	 * 将下载的网络图片保存在指定位置
	 * @throws Exception
	 */
	@Test
	void contextLoads2() throws Exception {
		String fileUrl = "https://gimg2.baidu.com/image_search/src=http%3A%2F%2Flmg.jj20.com%2Fup%2Fallimg%2F1114%2F040221103339%2F210402103339-8-1200.jpg&refer=http%3A%2F%2Flmg.jj20.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=auto?sec=1671595329&t=5ec956a905e71e684a67bcb53b014d2f";
		String newUrl = "G:\\a\\花.jpg";
		InputStream is = new URL(fileUrl).openStream();
		BufferedOutputStream baos = new BufferedOutputStream(new FileOutputStream(newUrl));
		IOUtils.copyLarge(is, baos);

	}

}
