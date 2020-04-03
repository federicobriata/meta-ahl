pkill cninjam
pkill ninjamsrv
ninjamsrv /etc/ninjam.cfg &
cninjam 127.0.0.1 -user anonymous:aidadsp -jack &
#jack_connect "ninjam:out1" "system:playback_1"
#jack_connect "ninjam:out2" "system:playback_2"

