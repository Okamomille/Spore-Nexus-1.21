package net.okamiz.sporenexus.util;

import net.minecraft.core.particles.DustParticleOptions;
import net.minecraft.world.phys.Vec3;
import org.joml.Vector3f;

public class SNDustParticleOptions extends DustParticleOptions {

    public static final Vector3f HASTE_PARTICLE_COLOR = Vec3.fromRGB24(16771123).toVector3f();
    public static final Vector3f NIGHT_VISION_COLOR = Vec3.fromRGB24(3421183).toVector3f();
    public static final Vector3f FIRE_RESISTANCE_COLOR = Vec3.fromRGB24(16743987).toVector3f();
    public static final SNDustParticleOptions HASTE = new SNDustParticleOptions(HASTE_PARTICLE_COLOR, 1.0F);
    public static final SNDustParticleOptions NIGHT_VISION = new SNDustParticleOptions(NIGHT_VISION_COLOR, 1.0F);
    public static final SNDustParticleOptions FIRE_RESISTANCE = new SNDustParticleOptions(FIRE_RESISTANCE_COLOR, 1.0F);

    public SNDustParticleOptions(Vector3f color, float scale) {
        super(color, scale);
    }


}
