import React,{useEffect, useState} from "react";
import { View,Text, StyleSheet, Image, TouchableOpacity, TextInput, ActivityIndicator, FlatList } from 'react-native';
import * as Animatable from 'react-native-animatable'
export default function Rotas (){
    const[rotas,setRotas]=useState([]);
    const[carregando,setCarregando]=useState(true);
    const getRotas = async () =>{
       
            const response = await
            fetch('http://localhost:8080/rotas')
            .then((resp)=>resp.json())
            .then((json)=>setRotas(json))
            .catch(()=>(alert('Erro ao obter Rotas! Tente novamente')))
            .finally(()=>setCarregando(false))
        
    }
    useEffect(()=>{
        getRotas();
            
        },[]);
    return(
        <View style={styles.container}>
        <Animatable.View animation={'fadeInLeft'}delay={500} style={styles.containerHeader} >
            <Text style={styles.message}> Seja Bem Vindo ! </Text>
            <Text style={styles.title}> Rotas </Text>
            {
                carregando ? <ActivityIndicator/>:(
                    <FlatList
                        data={rotas}
                        keyExtractor={({id},index)=>id}
                        renderItem={({item})=>(
                            <Text>{item.nome}</Text>
                        )}
                        />
                )
            }
        </Animatable.View>
        </View>
    )
        }

        const styles = StyleSheet.create({
            container:{
                flex:1,
                backgroundColor:'#38a29d'
            },
            containerHeader:{
                marginTop:'14%',
                marginBottom: '8%',
                paddingStart:'5%',
            },
            message:{
                fontSize:28,
                fontWeight:"bold",
                color: '#FFF'
            },
            containerForm:{
                backgroundColor:'#FFF',
                flex:1,
                borderTopLeftRadius:25,
                borderTopRightRadius:25,
                paddingStart:'5%',
                paddingEnd:'5%'
            },
            title:{
                fontSize:20,
                marginTop:20,
            },
            button:{
                backgroundColor:'#38a29d',
                width:'100%',
                borderRadius:4,
                paddingVertical:8,
                marginTop:14,
                justifyContent:'center',
                alignItems:'center'
            },
            buttonText:{
                color:'#FFF',
                fontSize:18,
                fontWeight:'bold'
            },
            buttonRegister:{
                marginTop:14,
                alignSelf:'center'
            },
            registerText:{
                color:'#a1a1a1'
            }

        })
        