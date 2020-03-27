#!/bin/bash
sclang /usr/share/SuperCollider/Extensions/FoxDot/foxdot.scd &
#jack_connect "SuperCollider:out_1" "system:playback_1"
#jack_connect "SuperCollider:out_2" "system:playback_2"
sleep 3
foxdot.py

