#!/bin/sh
#title           :cleaner.sh
#description     :This script will clean a given directory.
#author		     :rahernandez
#date            :24062023
#version         :0.1
#usage		     :sh cleaner.sh
#notes           :Install Git-Bash to use this script.
#bash_version    :5.2.15(1)-release (x86_64-pc-msys)

echo "--> cleaning.."
rm -rf *.html *.xml *.png
echo "--> done!"
