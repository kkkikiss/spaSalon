package main.com.vsu.service;
import main.com.vsu.entity.Profile;
import main.com.vsu.repository.ProfileRepository;

public class ProfileService {
    private final ProfileRepository profileRepository;

    public ProfileService(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }


    public Profile login(String login, String password)  {
        Profile profile = profileRepository.getByLogin(login);
        if (profile != null && getPasswordHash(password).equals(profile.getPassword())){
            return profile;
        }
        return null;
    }

    private String getPasswordHash(String password) {
        return String.valueOf(password.hashCode());
    }

    public boolean canRegister(String login) {
        Profile profile = profileRepository.getByLogin(login);
        return  profile == null;
    }

    public void register(Profile profile) {
        profile.setPassword(getPasswordHash(profile.getPassword()));
        profileRepository.insert(profile);
    }
}
