package lbarros.microservicio.ConfigRepoGit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class ConfigRepoGitApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConfigRepoGitApplication.class, args);
	}
	
	/* Las configuraciones de los archivos respectivos se pueden visualizar en la ruta de la app por ejemplo
	 * http://localhost:4444/config-eureka-server/default/main
	*/

}
