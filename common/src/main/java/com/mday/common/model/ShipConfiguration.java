package com.mday.common.model;

import javax.annotation.Nonnull;

/**
 * Defines the configuration information for a specific class of ship.
 */
public class ShipConfiguration {
    private final double radius;
    private final double weight;
    private final int hitPoints;
    private final int engines;
    private final int thrusters;
    private final int sensors;
    private final int defenses;
    private final int weapons;
    private final int energy;

    private ShipConfiguration(
            final double radius, final double weight, final int hitPoints, final int engines, final int thrusters,
            final int sensors, final int defenses, final int weapons, final int energy) {
        this.radius = radius;
        this.weight = weight;
        this.hitPoints = hitPoints;
        this.engines = engines;
        this.thrusters = thrusters;
        this.sensors = sensors;
        this.defenses = defenses;
        this.weapons = weapons;
        this.energy = energy;
    }

    /**
     * Retrieve the size of the ship.
     *
     * @return the size of the ship
     */
    public double getRadius() {
        return radius;
    }

    /**
     * Retrieve the weight of the ship.
     *
     * @return the weight of the ship
     */
    public double getWeight() {
        return weight;
    }

    /**
     * Retrieve the starting hit points for the ship.
     *
     * @return the starting hit points for the ship
     */
    public int getHitPoints() {
        return hitPoints;
    }

    /**
     * Retrieve the number of engines supported on the ship.
     *
     * @return the number of engines supported on the ship
     */
    public int getEngines() {
        return engines;
    }

    /**
     * Retrieve the number of thrusters supported on the ship.
     *
     * @return the number of thrusters supported on the ship
     */
    public int getThrusters() {
        return thrusters;
    }

    /**
     * Retrieve the number of sensor systems supported on the ship.
     *
     * @return the number of sensor systems supported on the ship
     */
    public int getSensors() {
        return sensors;
    }

    /**
     * Retrieve the number of defensive systems supported on the ship.
     *
     * @return the number of defensive systems supported on the ship
     */
    public int getDefenses() {
        return defenses;
    }

    /**
     * Retrieve the number of weapon systems supported on the ship.
     *
     * @return the number of weapon systems supported on the ship
     */
    public int getWeapons() {
        return weapons;
    }

    /**
     * Retrieve the number of energy storage systems supported on the ship.
     *
     * @return the number of energy storage systems supported on the ship
     */
    public int getEnergy() {
        return energy;
    }

    /**
     * A builder class used to create ship configurations.
     */
    public static class Builder {
        private double radius = 0;
        private double weight = 0;
        private int hitPoints = 0;
        private int engines = 0;
        private int thrusters = 0;
        private int sensors = 0;
        private int defenses = 0;
        private int weapons = 0;
        private int energy = 0;

        /**
         * Set the radius to use when creating the ship configuration.
         *
         * @param radius the new radius value
         * @return {@code this}
         */
        @Nonnull
        public Builder withRadius(final double radius) {
            this.radius = radius;
            return this;
        }

        /**
         * Set the weight to use when creating the ship configuration.
         *
         * @param weight the new weight value
         * @return {@code this}
         */
        @Nonnull
        public Builder withWeight(final double weight) {
            this.weight = weight;
            return this;
        }

        /**
         * Set the hit points to use when creating the ship configuration.
         *
         * @param hitPoints the new hit points value
         * @return {@code this}
         */
        @Nonnull
        public Builder withHitPoints(final int hitPoints) {
            this.hitPoints = hitPoints;
            return this;
        }

        /**
         * Set the engines to use when creating the ship configuration.
         *
         * @param engines the new engines value
         * @return {@code this}
         */
        @Nonnull
        public Builder withEngines(final int engines) {
            this.engines = engines;
            return this;
        }

        /**
         * Set the thrusters to use when creating the ship configuration.
         *
         * @param thrusters the new thrusters value
         * @return {@code this}
         */
        @Nonnull
        public Builder withThrusters(final int thrusters) {
            this.thrusters = thrusters;
            return this;
        }

        /**
         * Set the sensors to use when creating the ship configuration.
         *
         * @param sensors the new sensors value
         * @return {@code this}
         */
        @Nonnull
        public Builder withSensors(final int sensors) {
            this.sensors = sensors;
            return this;
        }

        /**
         * Set the defenses to use when creating the ship configuration.
         *
         * @param defenses the new defenses value
         * @return {@code this}
         */
        @Nonnull
        public Builder withDefenses(final int defenses) {
            this.defenses = defenses;
            return this;
        }

        /**
         * Set the weapons to use when creating the ship configuration.
         *
         * @param weapons the new weapons value
         * @return {@code this}
         */
        @Nonnull
        public Builder withWeapons(final int weapons) {
            this.weapons = weapons;
            return this;
        }

        /**
         * Set the energy to use when creating the ship configuration.
         *
         * @param energy the new energy value
         * @return {@code this}
         */
        @Nonnull
        public Builder withEnergy(final int energy) {
            this.energy = energy;
            return this;
        }

        /**
         * Create the ship configuration.
         *
         * @return the created ship configuration
         */
        @Nonnull
        public ShipConfiguration build() {
            return new ShipConfiguration(
                    radius, weight, hitPoints, engines, thrusters, sensors, defenses, weapons, energy);
        }
    }
}
