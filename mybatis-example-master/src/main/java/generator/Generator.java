package generator;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jxilong on 2016/8/26.
 */
public class Generator {
	
	public static void main(String[] args) {
		try {
			List<String> warnings = new ArrayList<>();
			boolean overwrite = true;
			Resource resource = new ClassPathResource("generator/generator.xml");
			ConfigurationParser cp = new ConfigurationParser(warnings);
			Configuration config = cp.parseConfiguration(resource.getFile());
			DefaultShellCallback callback = new DefaultShellCallback(overwrite);
			MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
			myBatisGenerator.generate(null);
			System.out.print("Generator finished");
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
}
