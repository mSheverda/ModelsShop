package ua.com.models.model;


import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "users")
public class User extends Model implements UserDetails {

    private static final long serialVersionUID = 1L;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "phone", nullable = false)
    private String phone;

    @Column(name = "vkontakte")
    private String vkontakte;

    @Column(name = "facebook")
    private String facebook;

    @Column(name = "skype")
    private String skype;

    @Column(name = "description")
    private String description;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "role_id", referencedColumnName = "id")
    private Role role;

  //  @OneToMany(fetch = FetchType.LAZY, mappedBy = "client", cascade = CascadeType.REMOVE)
  //  private List<Order> clientOrders = new ArrayList<>();

  //  @OneToMany(fetch = FetchType.LAZY, mappedBy = "manager", cascade = CascadeType.REMOVE)
  //  private List<Order> managerOrders = new ArrayList<>();

    public User() {
        this("", "", "", null);
    }

    public User(String name, String email, String phone, Role role) {
        super();
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.role = role;
        this.username = "";
        this.password = "";
        this.vkontakte = "";
        this.facebook = "";
        this.skype = "";
        this.description = "";
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Name: ").append(this.name)
                .append("\nRole: ").append(this.role.getDescription())
                .append("\nEmail: ").append(this.email)
                .append("\nPhone: ").append(this.phone);
        return sb.toString();
    }

    @Override
    public String toEquals() {
        return getName() + getEmail() + getPhone();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> roles = new ArrayList<>();
        roles.add(new SimpleGrantedAuthority("ROLE_" + this.role.getTitle().name()));
        return roles;
    }

    public void initialize(String name, String username, String password, String email,
                           String phone, String vkontakte, String facebook, String skype,
                           String description, Role role
    ) {
        setName(name);
        setUsername(username);
        setPassword(password);
        setEmail(email);
        setPhone(phone);
        setVkontakte(vkontakte);
        setFacebook(facebook);
        setSkype(skype);
        setDescription(description);
        setRole(role);
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name != null ? name : "";
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username != null ? username : "";
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password != null ? password : "";
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email != null ? email : "";
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone != null ? phone : "";
    }

    public String getVkontakte() {
        return this.vkontakte;
    }

    public void setVkontakte(String vkontakte) {
        this.vkontakte = vkontakte != null ? vkontakte : "";
    }

    public String getFacebook() {
        return this.facebook;
    }

    public void setFacebook(String facebook) {
        this.facebook = facebook != null ? facebook : "";
    }

    public String getSkype() {
        return this.skype;
    }

    public void setSkype(String skype) {
        this.skype = skype != null ? skype : "";
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description != null ? description : "";
    }

    public Role getRole() {
        return this.role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

 //   public List<Order> getClientOrders() {
 //       return getUnmodifiableList(this.clientOrders);
  //  }

 //   public void setClientOrders(List<Order> clientOrders) {
//        this.clientOrders = clientOrders;
 //   }

 //   public List<Order> getManagerOrders() {
 //       return getUnmodifiableList(this.managerOrders);
 //   }

//   public void setManagerOrders(List<Order> managerOrders) {
//        this.managerOrders = managerOrders;
//    }

}
