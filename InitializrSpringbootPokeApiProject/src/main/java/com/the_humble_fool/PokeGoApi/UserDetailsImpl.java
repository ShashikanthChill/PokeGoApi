/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.the_humble_fool.PokeGoApi;

import com.the_humble_fool.PokeGoApi.models.entitymodels.UsersEntityModel;
import com.the_humble_fool.PokeGoApi.models.entitymodels.UserRolesEntityModel;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 *
 * @author The_Humble_Fool
 */
public class UserDetailsImpl implements UserDetails
{

    private final UsersEntityModel user;

    public UserDetailsImpl(UsersEntityModel user)
    {
        this.user = user;
        System.out.println("UserDetailsImpl created with user: " + this.user);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities()
    {
        List<UserRolesEntityModel> userRolesList = user.getUserRolesList();
        List<SimpleGrantedAuthority> authorities = userRolesList.stream().map((t) -> {
            System.out.println("User role: " + t.getUserRole());
            return new SimpleGrantedAuthority(t.getUserRole());
        }).collect(Collectors.toList());
        return authorities;
    }

    @Override
    public String getPassword()
    {
        return user.getPassword();
    }

    @Override
    public String getUsername()
    {
        return user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired()
    {
        return true;
    }

    @Override
    public boolean isAccountNonLocked()
    {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired()
    {
        return true;
    }

    @Override
    public boolean isEnabled()
    {
        return true;
    }

}
