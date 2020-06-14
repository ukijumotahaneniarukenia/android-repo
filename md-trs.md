# 1

- 事象
  - エミュレータが起動しない

  - https://www.virment.com/create-virtual-machine-android-studio-ubuntu/
  
  - https://qiita.com/ceratophry/items/0b2a974f3c02a2d4b23c#comments

- 原因

dockerホストはkvmグループあるのに対し、dockerコンテナ上は存在しない

```
doc-ubuntu-18-04-vim (kuraine)  03:13:19  java  (master)  ls -al /dev/kvm
crw-rw---- 1 root 108 10, 232  6月  9 02:46 /dev/kvm
doc-ubuntu-18-04-vim (kuraine)  03:13:31  java  (master)  exit
aine-MS-7B98 (aine)  03:13:43  ubuntu-18-04-vim  (master)  ls -al /dev/kvm
crw-rw----+ 1 root kvm 10, 232  6月  9 02:43 /dev/kvm

doc-ubuntu-18-04-vim (kuraine)  03:14:30  ~   cat /etc/group | grep kvm
```

- 対応

パッケージインストール

```
apt install -y qemu-kvm


doc-ubuntu-18-04-vim (kuraine)  03:17:47  ~   cat /etc/group | grep kvm
kvm:x:108:

doc-ubuntu-18-04-vim (kuraine)  03:18:18  ~   ls -al /dev/kvm
crw-rw---- 1 root kvm 10, 232  6月  9 02:46 /dev/kvm


実行ユーザをkvmグループに追加
doc-ubuntu-18-04-vim (kuraine)  03:19:35  ~   sudo adduser kuraine kvm
Adding user `kuraine' to group `kvm' ...
Adding user kuraine to group kvm
Done.

```



再ログイン


```
doc-ubuntu-18-04-vim (kuraine)  03:20:26  ~   exit
aine-MS-7B98 (aine)  03:20:30  ubuntu-18-04-vim  (master)  docker exec -it ubuntu-18-04-vim /bin/bash

```

- 予防
