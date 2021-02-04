# JoinQuitMessage
Mohistの鯖で入退出のメッセージが出なくなったので作りました。  
Spigotの1.12のAPIを使用しており、Mohist1.12.2-182で動作を確認しています。  
BDS、Nukkit、PMMPなどのBE系サーバーのプラグインではありません。  

### Settings
| コマンド | Configでの項目 | 説明 |
| --- | --- | --- |
| `/setmsgjoin <String:メッセージ>` | `joinmessage` | サーバーにログインした時のメッセージを設定します。 |
| `/setmsgquit <String:メッセージ>` | `quitmessage` | サーバーからログアウトした時のメッセージを設定します。 |
| `/setmsgjoinop <String:メッセージ>` | `opjoinmessage` | OPがサーバーにログインした時のメッセージを設定します。 |
| `/setmsgquitop <String:メッセージ>` | `opquitmessage` | OPがサーバーからログアウトした時のメッセージを設定します。 |


メッセージ内にスペースを入れる場合、ダブルクオーテーションは不要です。  
メッセージ内に`{name}`を入れると、プレイヤー名に置換されます。(例: {name}が参加 → Steveが参加)  
