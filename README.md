# ms-app-medica-pacientes-bs

Capa **BS** (Business Service) del módulo **Pacientes**. Concentra la lógica de negocio y validaciones del dominio; no accede a la base de datos directamente, sino que delega en `ms-app-medica-pacientes-db` mediante un Feign Client.

| | |
|---|---|
| **Puerto** | `8081` |
| **Patrón** | Controller → Service → Client (Feign) |
| **Ruta base** | `/api/pacientes` |
| **Llama a** | `pacientes-db` (8083) · `citas-bs` (8091, para enriquecer con citas) |

## Ejecución

```bash
# Con todo el ecosistema (recomendado), desde app-medica-et-fullstack-1/
docker compose up --build

# Individual
./mvnw spring-boot:run     # mvnw.cmd en Windows
./mvnw test
```
