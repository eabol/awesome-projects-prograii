package org.tricodex.view.services;

public class EntityService {
    private int spawningTime = 0;
    private int despawningTime = 0;
    private int respawnCooldown = 0;
    private boolean hasSpawned = false;
    private final int spawningTimeLimit;
    private final int despawningTimeLimit;
    private final int respawnCooldownLimit;

    public EntityService(int spawningTimeLimit, int despawningTimeLimit, int respawnCooldownLimit) {
        this.spawningTimeLimit = spawningTimeLimit;
        this.despawningTimeLimit = despawningTimeLimit;
        this.respawnCooldownLimit = respawnCooldownLimit;
    }

    public void reset() {
        this.spawningTime = 0;
        this.despawningTime = 0;
        this.hasSpawned = false;
        this.respawnCooldown = 0;
    }

    public void update() {
        if (!hasSpawned) {
            if(respawnCooldown < respawnCooldownLimit){
                respawnCooldown++;
            }else {
                spawningTime++;
                if (spawningTime == spawningTimeLimit) {
                    hasSpawned = true;
                    spawningTime = 0;
                    respawnCooldown = 0;
                }
            }
        } else {
            despawningTime++;
            if (despawningTime >= despawningTimeLimit) {
                hasSpawned = false;
                despawningTime = 0;
            }
        }
    }

    public boolean hasEntitySpawned() {
        return hasSpawned;
    }
}
