package ua.com.models.configuration;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import ua.com.models.enums.RoleEnum;
import ua.com.models.service.RoleService;

@Configuration
@EnableWebSecurity
@ComponentScan(basePackages = {"ua.com.models.service", "ua.com.models.dao", "ua.com.models.repository"})
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private static final String ADMIN_REQUEST_URl = "/admin/**";

    private static final String MANAGER_REQUEST_URl = "/manager/**";

    private static final String LOGIN_URL = "/login";

    private static final String USERNAME = "username";

    private static final String PASSWORD = "password";

    private static final String ACCESS_DENIED_PAGE = "/forbidden_exception";

    private static final String DEFAULT_LOGIN = "adminka1";

    private static final String DEFAULT_PASSWORD = "vitaminka1";

    @Autowired
    public UserDetailsService userDetailsService;

    @Autowired
    private RoleService roleService;

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .authorizeRequests()
                .antMatchers(ADMIN_REQUEST_URl)
                .hasRole( this.roleService.getAdministrator().getTitle().name()
                       // String.valueOf(RoleEnum.ADMIN)
                )
                .antMatchers(MANAGER_REQUEST_URl)
                .hasAnyRole(roleService.getAdministrator().getTitle().name(), this.roleService.getManager().getTitle().name())
                .anyRequest().permitAll()
                .and()
                .formLogin()
                .loginPage(LOGIN_URL)
                .usernameParameter(USERNAME)
                .passwordParameter(PASSWORD)
                .defaultSuccessUrl("/", false)
                .and()
                .exceptionHandling().accessDeniedPage(ACCESS_DENIED_PAGE).and()
                .csrf().disable();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder builder) throws Exception {
        builder
                .userDetailsService(this.userDetailsService).and()
                .inMemoryAuthentication()
                .withUser(DEFAULT_LOGIN).password(DEFAULT_PASSWORD)
                .roles(this.roleService.getAdministrator().getTitle().name()
                       // String.valueOf(RoleEnum.ADMIN)
                );
    }
}