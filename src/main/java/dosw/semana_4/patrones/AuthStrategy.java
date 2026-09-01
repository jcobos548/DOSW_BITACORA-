package dosw.semana_4.patrones;

public interface AuthStrategy {
    AuthResult authenticate(Credentials credentials);
}