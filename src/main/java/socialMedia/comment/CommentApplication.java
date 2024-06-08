package socialMedia.comment;

import org.modelmapper.ModelMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import socialMedia.comment.models.Role;
import socialMedia.comment.services.conretes.AuthManager;
import socialMedia.comment.services.dtos.requests.userRequest.AddUserRequest;

import java.util.Set;

@SpringBootApplication
public class CommentApplication implements CommandLineRunner {

	private final AuthManager authManager;


	@Bean
	public ModelMapper getModelMapper() {
		return new ModelMapper();
	}
	public CommentApplication(AuthManager authManager){
		this.authManager = authManager;
	}

	public static void main(String[] args) {
		SpringApplication.run(CommentApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
      createDummyData();
	}
	private void createDummyData(){
		AddUserRequest requestAdmin = AddUserRequest
				.builder()
				.username("ADMIN")
				.password("password")
				.email("feyzakrnfl@gmail.com")
				.authorities(Set.of(Role.ROLE_ADMIN))
				.build();

		AddUserRequest requestUser = AddUserRequest
				.builder()
				.username("USER")
				.password("password")
				.email("feyzakrnfl@gmail.com")
				.authorities(Set.of(Role.ROLE_USER))
				.build();

		if(authManager.getByUsername(requestAdmin.getUsername()).isEmpty()){
			authManager.register(requestAdmin);
		}
		if(authManager.getByUsername(requestUser.getUsername()).isEmpty()){
			authManager.register(requestUser);
		}
	}


}
