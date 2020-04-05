#!/bin/bash
sclang /usr/share/SuperCollider/Extensions/FoxDot/foxdot.scd &
sleep 3

# SC connect to jack by default
#jack_connect "SuperCollider:out_1" "system:playback_1"
#jack_connect "SuperCollider:out_2" "system:playback_2"

# Uncomment to route SC to Ninjam
#jack_diconnect "SuperCollider:out_1" "system:playback_1"
#jack_diconnect "SuperCollider:out_2" "system:playback_2"
#jack_connect "SuperCollider:out_1" "ninjam:in1"
#jack_connect "SuperCollider:out_2" "ninjam:in2"

foxdot.py

