#!/bin/bash

ps -ef|grep webase-bee |grep -v grep| awk '{print $2}'|xargs kill -9